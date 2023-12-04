/**
 * 
 */
package lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * TASK 1 : BASIC OPERATIONS WITH BST
 * 
 * @author hp
 *
 */
public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			this.root = new BNode<E>(e);
		} else if (e.compareTo(root.getData()) < 0) {
			if (root.getLeft() == null) {
				root.setLeft(new BNode<E>(e));
			} else {
				addRecursive(root, e);
			}
		} else if (e.compareTo(root.getData()) > 0) {
			if (root.getRight() == null) {
				root.setRight(new BNode<E>(e));
			} else {
				addRecursive(root, e);
			}
		}
	}

	// This method is support the add method
	public void addRecursive(BNode<E> root, E e) {
		if (e.compareTo(root.getData()) < 0) {
			if (root.getLeft() == null) {
				root.setLeft(new BNode<E>(e));
			} else {
				addRecursive(root.getLeft(), e);
			}
		} else if (e.compareTo(root.getData()) > 0) {
			if (root.getRight() == null) {
				root.setRight(new BNode<E>(e));
			} else {
				addRecursive(root.getRight(), e);
			}
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}

	}

	// compute the depth of a node in BST
	public int depth(E node) {
		return countDepthOfNode(root, node, 0);
	}

	// This method is support the depth method
	public int countDepthOfNode(BNode<E> root, E node, int count) {
		if (root == null) {
			return -1; // Nếu không tìm thấy nút, trả về -1
		}

		if (node.compareTo(root.getData()) == 0) {
			return count; // Nếu tìm thấy nút, trả về độ sâu hiện tại
		}

		if (node.compareTo(root.getData()) < 0) {
			return countDepthOfNode(root.getLeft(), node, count + 1);
		} else {
			return countDepthOfNode(root.getRight(), node, count + 1);
		}
	}

	// This method is support the depth method
	// This method is check if node is equals the root
	public boolean isNode(BNode<E> root, E node) {
		return (node.equals(root.getData()));
	}

	// compute the height of BST
	public int height() {
		return countHeightOfBranch(root);
	}

	// This method is support the height method
	public int countHeightOfBranch(BNode<E> root) {
		if (root == null) {
			return 0;
		} else {
			int countLeft = countHeightOfBranch(root.getLeft());
			int countRight = countHeightOfBranch(root.getRight());
			return Math.max(countLeft, countRight) + 1;
		}

	}

	// Compute total nodes in BST
	public int size() {
		  return countNode(root);
    }

    public int countNode(BNode<E> root) {
        if (root == null) {
            return 0;
        } else {
            int countLeft = countNode(root.getLeft());
            int countRight = countNode(root.getRight());
            return countLeft + countRight + 1;
        }
	}

	// Check whether element e is in BST
	public boolean contains(E e) {

		return containsNode(root, e);
	}

	// This method is support the contain method
	public boolean containsNode(BNode<E> node, E e) {
		if (node == null) {
			return false;
		}
		if (e.compareTo(node.getData()) == 0) {
			return true;
		}
		if (e.compareTo(node.getData()) < 0) {
			return containsNode(node.getLeft(), e);
		} else {
			return containsNode(node.getRight(), e);
		}

	}

	// Find the minimum element in BST
	public E findMin() {

		if (root == null) {
			return null;
		}
		BNode<E> current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current.getData();

	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null) {
			return null;
		}
		BNode<E> current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current.getData();

	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		}
		BNode<E> parent = null;
		BNode<E> current = root;
		boolean isLeftChild = false;
		while (current != null && !current.getData().equals(e)) {
			parent = current;
			if (e.compareTo(current.getData()) < 0) {
				current = current.getLeft();
				isLeftChild = true;
			} else {
				current = current.getRight();
				isLeftChild = false;
			}
		}
		if (current == null) {
			return false;
		}
		if (current.getLeft() == null && current.getRight() == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		} else if (current.getRight() == null) {
			if (current == root) {
				root = current.getLeft();
			} else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else if (current.getLeft() == null) {
			if (current == root) {
				root = current.getRight();
			} else if (isLeftChild) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		} else {
			BNode<E> successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.setLeft(successor);
			} else {
				parent.setRight(successor);
			}
			successor.setLeft(current.getLeft());
		}
		return true;

	}

	// This method is support the remove method
	public BNode<E> getSuccessor(BNode<E> node) {
		BNode<E> successorParent = node;
		BNode<E> successor = node;
		BNode<E> current = node.getRight();
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeft();
		}
		if (successor != node.getRight()) {
			successorParent.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}
		return successor;
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		List<E> descendantsList = new ArrayList<>();
		BNode<E> node = findNode(root, data);
		if (node != null) {
			addDescendantsToList(node, descendantsList);
		}
		return descendantsList;
	}

	// This method is support the descendants method
	public void addDescendantsToList(BNode<E> node, List<E> descendantsList) {
		if (node != null) {
			if (node.getLeft() != null) {
				addDescendantsToList(node.getLeft(), descendantsList);
			}
			if (node.getRight() != null) {
				addDescendantsToList(node.getRight(), descendantsList);
			}
			descendantsList.add(node.getData());
		}
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		List<E> ancestorsList = new ArrayList<>();
		BNode<E> node = findNode(root, data);
		if (node != null) {
			addAncestorsToList(root, node, ancestorsList);
		}
		return ancestorsList;
	}

	// This method is support the ancestors method
	public void addAncestorsToList(BNode<E> current, BNode<E> target, List<E> ancestorsList) {
		if (current != null) {
			if (current.getData().equals(target.getData())) {
				return;
			}
			ancestorsList.add(current.getData());
			if (target.getData().compareTo(current.getData()) < 0) {
				addAncestorsToList(current.getLeft(), target, ancestorsList);
			} else {
				addAncestorsToList(current.getRight(), target, ancestorsList);
			}
		}

	}

	// This method is support the ancestors method and descendants method
	public BNode<E> findNode(BNode<E> node, E data) {
		if (node == data) {
			return node;

		} else if (node.getData().compareTo(data) < 0) {
			findNode(node.getRight(), data);
		} else if (node.getData().compareTo(data) > 0) {
			findNode(node.getLeft(), data);
		}
		return node;
	}

	// This method is support the main method to print the tree. It traverse the
	// tree in left - root - right order
	public static void getSequence(BNode<Integer> root, List<Integer> sequence) {
		if (root != null) {
			getSequence(root.getLeft(), sequence);
			sequence.add(root.getData());
			getSequence(root.getRight(), sequence);

		}
	}

	/**
	 * @return the root
	 */
	public BNode<E> getRoot() {
		return root;
	}

	// This is the main method of class
	public static void main(String[] args) {
		// This is the testcase of add method
		BST<Integer> tree = new BST<Integer>();
		tree.add(9);
		tree.add(3);
		tree.add(15);
		tree.add(20);
		tree.add(21);
		tree.add(19);
		tree.add(7);
		tree.add(10);
		tree.add(1);
		tree.add(2);
		tree.add(5);
		tree.add(8);
		tree.add(11);

		// This is the testcase of add method to add a collections
		// Create the new tree to add a list on.
		BST<Integer> tree1 = new BST<Integer>();
		Collection<Integer> list = new HashSet<>();
		list.add(5);
		list.add(8);
		list.add(9);
		list.add(4);
		list.add(10);
		list.add(1);
		list.add(2);
		tree1.add(list);
		List<Integer> arraylist = new ArrayList<>();
		getSequence(tree1.getRoot(), arraylist);
		System.out.println(arraylist);

		// This is the testcase of depth method
		System.out.println(tree.depth(2));
		// This is the testcase of height method
		System.out.println(tree.height());
		// This is the testcase of size method
		System.out.println(tree.size());
		// This is the testcase of add method
		System.out.println(tree.contains(4));
		System.out.println(tree.contains(1));
		// This is the testcase of findMin method
		System.out.println(tree.findMin());
		// This is the testcase of findMax method
		System.out.println(tree.findMax());
		// This is the testcase of remove method
		System.out.println(tree.remove(9));
		//This is the testcase of descendants method
		System.out.println(tree.descendants(10));
		//This is the testcase of ancestors(7 method
		System.out.println(tree.ancestors(7));
		
	}
}
