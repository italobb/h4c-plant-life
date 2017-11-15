pragma solidity ^0.4.13;

contract Carbon4All {
    
    uint public treesCount = 0;

    struct Tree{
        uint id;
        
        /**
         * Tree's owner.
         */ 
        address owner;
        
        string  word1;
        string  word2;
        string  word3;
        
    }
    
    mapping(bytes32 => Tree) trees;
    
    /**
     * @return the hashed words.
     */
    function hashSecret(string word1, string word2, string word3)
        constant
        public
        returns(bytes32 hashed)
    {
        return keccak256(word1,word2,word3);        
    }
    
    /**
     * Stores a tree on the blockchain.
     * Throws if tree with such lat long combination is already exists.
     * 
     * 
     * @return Hash of the tree.
     */
    function register(string word1, string word2, string word3) public returns (bytes32 treeHash) {

        // unique by lat long composition
        bytes32 hash = keccak256(word1,word2,word3);

        Tree memory existingTree = trees[hash];
        if (existingTree.id != 0)
            revert();
        
        Tree memory tree = Tree(++treesCount, msg.sender, word1,word2,word3);

        trees[hash] = tree;
        return hash;
    }
    
    /**
     * Returns a tree by it's hash.
     * Throws if tree is not exists.
     */ 
    function get(bytes32 treeHash) public constant returns (uint id, address owner) {
        Tree memory tree = getTree(treeHash);
        
        id = tree.id;
        owner = tree.owner;
    }
    
    /**
     * Returns a tree owner address by tree's hash.
     * Throws if tree is not exists.
     */ 
    function getOwner(bytes32 treeHash) public constant returns (address) {
        Tree memory tree = getTree(treeHash);
        return tree.owner;
    }
    
        
    /**
     * Returns if tree of the given hash exists.
     */ 
    function isExists(bytes32 treeHash) public constant returns (bool) {
        Tree memory tree = trees[treeHash];
        if (tree.id == 0)
            return false;
            
        return true;
    }
    
    /**
     * Returns a tree by it's hash.
     * Throws if tree is not exists.
     */ 
    function getTree(bytes32 treeHash) private constant returns (Tree) {
        Tree memory tree = trees[treeHash];
        if (tree.id == 0)
           revert();
           
        return tree;
    }
    
    /**
     * @dev Low level function.
     * Converts string to bytes32 array.
     * Throws if string length is more than 32 bytes
     * 
     * @param str string
     * @return bytes32 representation of str
     */
    function strToBytes(string str) constant private returns (bytes32 ret) {
        // var g = bytes(str).length;
        // if (bytes(str).length > 32) throw;
        
        assembly {
            ret := mload(add(str, 32))
        }
    } 
}