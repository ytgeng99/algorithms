Given an array of strings, return all groups of strings that are anagrams.

 Notice
All inputs will be in lower-case

Have you met this question in a real interview? 
Example
Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

// method 1 : based on sort
public class Solution {
    /*
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length < 2) {
        	return result;
        }

        Map<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i < strs.length; i++) {
        	char[] charArr = strs[i].toCharArray();
        	Arrays.sort(charArr);
        	String str = String.valueOf(charArr);

        	if (!hashMap.containsKey(str)) {
        		hashMap.put(str, new ArrayList<String>());
        	}

        	hashMap.get(str).add(strs[i]);
        }

        // loop through hashMap if the value contains more than two ele will be added to result
        for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()) {
        	if (entry.getValue().size() >= 2) {
        		result.addAll(entry.getValue());
        	}
        }
        return result;
    }
}



// method 2: based on hash
public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        List<String> results = new ArrayList<String>();
        if (strs == null) {
            return results;
        }

        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            int hash = getHash(count);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<String>());
            }
            map.get(hash).add(str);
        }

        for (ArrayList<String> tmp : map.values()) {
            if (tmp.size() > 1) {
                results.addAll(tmp);
            }
        }

        return results;
    }

    private int getHash(int[] count) {
        int hash = 0;
        int a = 378551;
        int b = 63689;
        for (int num : count) {
            hash = hash * a + num;
            a = a * b;
        }
        return hash;
    }
}

