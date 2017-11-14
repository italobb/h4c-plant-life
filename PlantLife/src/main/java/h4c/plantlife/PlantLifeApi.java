package h4c.plantlife;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import h4c.plantlife.model.Tree;
import h4c.plantlife.model.TreeImage;
import h4c.plantlife.model.TreeImageRepository;
import h4c.plantlife.model.TreeRepository;
import h4c.plantlife.model.User;
import h4c.plantlife.model.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
@RequestMapping("plant-life")
public class PlantLifeApi {
	private static final String imagesPath = "images/";

	@Autowired
	UserRepository userRepository;

	@Autowired
	TreeRepository treeRepository;

	@Autowired
	TreeImageRepository treeImageRepository;

	@ApiOperation("Save user.")
	@PostMapping("/user-register")
	public User registerUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

	@ApiOperation("User profile.")
	@GetMapping("/user-profile/{identityAddress}")
	public User userProfile(@PathVariable String identityAddress) {
		User user = userRepository.findOne(identityAddress);
		return user;
	}

	@ApiOperation("User details.")
	@GetMapping("/trees-counter/{identityAddress}")
	public Integer coutTreesByUser(@PathVariable String identityAddress) {
		User user = userRepository.findOne(identityAddress);
		return user.countTrees();
	}

	@ApiOperation("Lat/Lng to What3Words conversion")
	@GetMapping("/what3words")
	public List<String> w3w(@RequestParam Double lat, @RequestParam Double lng) {
		try {
			return What3Words.w3w(lat, lng);
		} catch (Exception e) {
			return Arrays.asList("what", "three", "words");
		}
	}

	@ApiOperation("Creates a tree")
	@PostMapping("/tree-create")
	public Tree create(@RequestBody Tree tree) {
		treeRepository.save(tree);
		return tree;
	}

	@ApiOperation("Save tree image and returns the image path")
	@PostMapping("/tree-image/{treeId}")
	public String saveImage(//
			@PathVariable("treeId") String treeId, //
			@ApiParam("User that took the picture") @PathVariable("userId") String userId, //
			@RequestParam("file") MultipartFile file) throws FileNotFoundException, IOException {
		TreeImage image = new TreeImage();
		image.setTreeId(treeId);
		image.setUserId(userId);
		String uuid = UUID.randomUUID().toString();
		image.setImageName(uuid + file.getName());

		File f = new File(image.getImageName());
		IOUtils.copy(file.getInputStream(), new FileOutputStream(f));

		return image.getImageName();
	}

	@ApiOperation("Download tree image by image name")
	@GetMapping(imagesPath + "{imageId}")
	public InputStreamResource loadImage(//
			@PathVariable("imageId") String imageId, //
			HttpServletResponse response) throws FileNotFoundException, IOException {
		File f = new File(imageId);
		response.addHeader("Cache-Control", "max-age=31536000");
		return new InputStreamResource(new FileInputStream(f), imageId);
	}

	@ApiOperation("Get tree details")
	@GetMapping("/tree/{treeId}")
	public Tree treeById(@PathVariable("treeId") String treeId) {
		return treeRepository.findOne(treeId);
	}

	@ApiOperation("Get tree images names")
	@GetMapping("/list-tree-images/{treeId}")
	public List<String> imagesByTree(//
			@PathVariable("treeId") String treeId) throws FileNotFoundException, IOException {
		List<TreeImage> treeImages = treeImageRepository.findByTreeId(treeId);
		List<String> images = new ArrayList<>();
		treeImages.forEach(i -> images.add(i.getImageName()));
		return images;
	}

}
