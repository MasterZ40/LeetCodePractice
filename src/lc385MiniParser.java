import com.sun.xml.internal.ws.api.pipe.NextAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by bzhao on 4/16/2018.
 */
public class lc385MiniParser {
    public static void main(String[] args){
        lc385MiniParser parser = new lc385MiniParser();
        NestedInteger ni= parser.deserialize2("[-1]");
        System.out.println(ni.serialize());
    }

    public NestedInteger deserialize(String s) {
        if(s.startsWith("[")) {
            //list, remove outer brackets
            String content = s.substring(1, s.length()-1);
            if(content.equals("")){
                return new NestedInteger();
            }

            NestedInteger ni = new NestedInteger();
            while(!content.equals("")) {
                int i = 0;
                //extract first element of the list, stopped by the first un-nested comma
                Stack<Character> stack = new Stack<Character>();
                for(; i < content.length(); i++){
                    char c = content.charAt(i);
                    if(c == '['){
                        stack.push(c);
                    }
                    if(c == ']'){
                        stack.pop();
                    }
                    if(c == ',' && stack.isEmpty()){
                        break;
                    }
                }
                String t = content.substring(0, i);
                ni.add(deserialize(t));
                if(i == content.length()){
                    return ni;
                }
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

    public NestedInteger deserialize2(String s) {
        //without recursion
        if(s.startsWith("[")) {
            //list
            String content = s.substring(1, s.length()-1);
            if(content.equals("")){
                return new NestedInteger();
            }

            NestedInteger ni = new NestedInteger();
            NestedInteger cur = ni;
            Stack<NestedInteger> stack = new Stack<NestedInteger>();
            String currentItem = "";
            for(int i = 0; i < content.length(); i++){


                if(content.charAt(i) == '['){
                    stack.push(cur);
                    NestedInteger niTemp = new NestedInteger();
                    cur = niTemp;

                }
                else if(content.charAt(i) == ']'){
                    if(!currentItem.equals("")){
                        int num = Integer.parseInt(currentItem);
                        cur.add(new NestedInteger(num));
                        currentItem = "";
                    }

                    NestedInteger top = stack.pop();
                    top.add(cur);
                    cur = top;
                }
                else if(content.charAt(i) == ','){
                    if(!currentItem.equals("")){
                        int num = Integer.parseInt(currentItem);
                        cur.add(new NestedInteger(num));
                        currentItem = "";
                    }

                }
                else{
                    currentItem += content.charAt(i);
                }
            }

            if(!currentItem.equals("")){
                int num = Integer.parseInt(currentItem);
                cur.add(new NestedInteger(num));
                currentItem = "";
            }

            return ni;
        }
        else {
            //int
            int num = Integer.parseInt(s);
            return new NestedInteger(num);

        }

    }
}


class NestedInteger {
    int m_integer;
    ArrayList<NestedInteger> m_list;
    boolean m_isInteger;

    // Constructor initializes an empty nested list.
    public NestedInteger(){
        m_isInteger = false;
        m_list = new ArrayList<NestedInteger>();
    }
    // Constructor initializes a single integer.
    public NestedInteger(int value){
        m_integer = value;
        m_isInteger = true;
    }
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){
        return m_isInteger;
    }
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        if(m_isInteger){
            return m_integer;
        }
        return null;
    }
    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        m_isInteger = true;
        m_integer = value;
        m_list = null;
    }
    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){
        m_isInteger = false;
        if(m_list == null){
            m_list = new ArrayList<NestedInteger>();
        }

        m_list.add(ni);
    }
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){
        if(m_isInteger){
            return null;
        }
        return m_list;
    }

    public String serialize(){
        if(m_isInteger){
            return Integer.toString(m_integer);
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(NestedInteger ni : m_list){
                if(ni != null){
                    sb.append(ni.serialize() + " ");
                }
            }
            return sb.toString();
        }
    }
}
