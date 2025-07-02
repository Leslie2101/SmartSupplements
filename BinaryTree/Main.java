package HW;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		BE8Tree tree = new BE8Tree();
		BE8Node node = new BE8Node();
		node.value = 1;

		tree.root = node;

		node = new BE8Node();
		node.value = 2;

		tree.root.right = node; 

		node = new BE8Node();
		node.value = 3;

		tree.root.right.right = node;

		node = new BE8Node();
		node.value = 5;
		tree.root.right.left = node;

		node = new BE8Node();
		node.value = 4;
		tree.root.right.right.left = node;

		node = new BE8Node();
		node.value = 6;
		tree.root.right.right.right = node;

		tree.balanceTree();

		ArrayList<BE8Node> imbalanceList = tree.findImbalanceNodes();
		System.out.println(imbalanceList.size());

		for (BE8Node be8Node : imbalanceList) {
			System.out.println(be8Node.value);
		}
	}

}
