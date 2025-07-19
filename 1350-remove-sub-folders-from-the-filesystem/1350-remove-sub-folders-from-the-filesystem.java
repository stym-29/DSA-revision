import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        for (String f : folder) {
            if (ans.isEmpty() || !f.startsWith(ans.get(ans.size() - 1) + "/")) {
                ans.add(f);
            }
        }
        return ans;
    }
}
