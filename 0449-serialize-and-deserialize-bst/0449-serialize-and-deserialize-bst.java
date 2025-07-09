public class Codec {

    public String serialize(TreeNode root) {
        String str = serializeToStr(root, new StringBuilder()).toString();
        return str.substring(0, str.length() - 1);
    }

    int ind = 0;

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserializeStr(arr);
    }

    private TreeNode deserializeStr(String[] arr) {
        if (arr[ind].equals("N")) {
            ind++;
            return null;
        }
        TreeNode t = new TreeNode(Integer.valueOf(arr[ind++]));
        t.left = deserializeStr(arr);
        t.right = deserializeStr(arr);
        return t;
    }

    private StringBuilder serializeToStr(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("N,");
            return res;
        }
        res.append(root.val).append(",");
        StringBuilder lStr = serializeToStr(root.left, res);
        StringBuilder rStr = serializeToStr(root.right, lStr);
        return rStr;
    }
}

