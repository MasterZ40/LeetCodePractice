import java.util.Stack;

/**
 * Created by bzhao on 4/16/2018.
 */
/*public class lc385MiniParser {
    public NestedInteger deserialize(String s) {
        if(s.startsWith("[")) {
            //list
            String content = s.substring(1, s.length()-1);
            if(content.equals("")){
                return new NestedInteger();
            }
            while(!content.equals("")) {
                int i = 0;
                Stack<Character> stack = new Stack<Character>();
                for(; i < content.length(); i++){
                    char c = content.charAt(i);
                    if(c == '['){
                        stack.push(c);
                    }
                    if(c == ']'){
                        stack.pop();
                        if(stack.isEmpty()){
                            break;
                        }
                    }
                }
                String t = content.substring(0, i+1);
                ni.add(deserialize(t));
                content = content.substring(i+1, content.length());
            }

            return ni;
        }
        else {
            //int
            int num = Integer.parseInt(s);
            return new NestedInteger(num);

        }

    }

}*/
