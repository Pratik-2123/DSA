package Tries;

public class triee {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    public static void Insert(String words) {
        Node curr = root;

        for(int i=0; i<words.length(); i++) {
            int idx = words.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean Search(String key) {
        Node curr = root;

        for(int i=0; i<key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if(key.length() == 0) {
            return true;
        }

        for(int i=1; i<=key.length(); i++) {   // i=1 se isiliye shuru kiya bcoz 1st half ko alag karne ke liye as the substring ka 2nd half is non inclusive ie why we have done this
            boolean validsearch = Search(key.substring(0, i));
            boolean rec = wordBreak(key.substring(i));
            if(validsearch && rec) {
                return true;
            }
        }

        return false;

    } 

    public static boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a' ;
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count+1;
    }

    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp) {
        if(root == null) {
            return;
        }

        for(int i=0; i<26; i++) {
            char ch = (char)(i+'a');
            if(root.children[i] != null && root.children[i].eow == true) {
                temp.append(ch);
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1); //backtracking ka step hy isse humare temp khali hota jayega
            }
        }
    }

    public static void main(String args[]) {
        // String words[] = {"the","a","there","their","any","thee"};
        // for(int i=0; i<words.length; i++) {
        //     Insert(words[i]);
        // }

        // System.out.println(Search("theee"));
        // System.out.println(Search("the"));
           
        // wordBreak problem

        // String words[] = {"i","like","sam","samsung","mobile","ice"};
        // String key = "ilikesam";
        // for(int i=0; i<words.length; i++) {
        //     Insert(words[i]);
        // }
        // System.out.println(Search("samsung"));
        // System.out.println(wordBreak(key));


        // startsWith Problem

        // String words[] = {"apple","app","mango","man","woman"};
        // String prefix1 = "app";
        // String prefix2 = "moon";
        
        // for(int i=0; i<words.length; i++) {
        //      Insert(words[i]);
        // }

        // System.out.println(startsWith(prefix1));
        // System.out.println(startsWith(prefix2));



        //Count unique Substrings
        // String str = "apple";

        // for(int i=0; i<str.length(); i++) {
        //     Insert(str.substring(i));
        // }
        // System.out.println(countNodes(root));

        String words[] ={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0; i<words.length; i++) {
            Insert(words[i]);
        }

        longestWord(root,new StringBuilder(""));
        System.out.println(ans);

    }
}
