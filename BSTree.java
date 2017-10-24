/**
 * 
 */
public class BSTree {
	private Node root;
	
	private class Node {
		private String key;
		private Node left, right;
		
		public Node(String key) {
			this.key = key;
		}
	}
	
	/**
	 * Finds a Comparable instance in the BST.
	 * 
	 * @param
	 * @return Returns “true” if found in the BST,
	 * 			“false” if not found in the BST.
	 */
	public boolean find(String key) {		
		return get(key) != null;
	}

	/**
	 * @param
	 * @return
	 */
	public String get(String key) {
		return get(root, key);
	}
	
	/**
	 * @param
	 * @param
	 * @return
	 */
	private String get(Node x, String key) {
		if (x == null) {
			return null;
		}
		
		int cmp = key.compareTo(x.key);
		
		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
    			return get(x.right, key);
		} else {
    			return key;
		}
	}

	/**
	 * Adds a Comparable instance to the BST.
	 * 
	 * @param
	 */
	public void insert(String key) {
		root = insert(root, key);
	}
	
	private Node insert(Node x, String key) {
		if (x == null) {
			return new Node(key);
		}
		
		int cmp = key.compareTo(x.key);
		
        if (cmp < 0) {
    			x.left  = insert(x.left, key);
        } else if (cmp > 0) {
    			x.right = insert(x.right, key);
        } else {
    			x.key = key;
        }
        
        return x;
	}
	
	/**
     * @param
     */
	public void delete(String key) {
        root = delete(root, key);
    }
	
	/**
     * @param
     * @param
     * @return
     */
    private Node delete(Node x, String key) {
        if (x == null) {
        		return null;
        }

        int cmp = key.compareTo(x.key);
        
        if (cmp < 0) {
        		x.left  = delete(x.left, key);
        } else if (cmp > 0) {
        		x.right = delete(x.right, key);
        } else { 
        		if (x.right == null) {
        			return x.left;
        		}
        		if (x.left  == null) {
        			return x.right;
        		}
            Node t = x;
            x.left = t.left;
        }
        
        return x;
    }
    
	public Object toStringInOrder() {
		return null;
	}

	public Object toStringPreOrder() {
		return null;
	}
}
