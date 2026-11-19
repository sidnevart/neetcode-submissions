class Solution {
    public String simplifyPath(String path) {
        char[] pathChars = path.toCharArray();
        String curDir = "";
        Stack<String> pathDirs = new Stack<>();
        Set<String> specificCmds = new HashSet<>();
        specificCmds.add("..");
        specificCmds.add(".");
        specificCmds.add("/");
        for (char c : pathChars){
            if (c == '/'){
                if (curDir.length() != 0){
                    if (curDir.equals("..")){
                        if(!pathDirs.isEmpty()){
                            pathDirs.pop();
                        }
                        curDir = "";
                    } else if (curDir.equals(".")){
                        curDir = "";
                    } else {
                        pathDirs.push(curDir);
                        curDir = "";
                    }
                }
            } else {
                curDir += c;
            }
        }
        if (curDir.length() != 0){
            if (curDir.equals("..")){
                if(!pathDirs.isEmpty()){
                    pathDirs.pop();
                }
                curDir = "";
            } else if (curDir.equals(".")){
                curDir = "";
            } else {
                pathDirs.push(curDir);
                curDir = "";
            }
        }

        String result = "";
        while(!pathDirs.isEmpty()){
            String dir = pathDirs.pop();
            result = "/" + dir + result;
        }

        return result.length() == 0 ? "/" : result;
    }
}