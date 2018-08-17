import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bzhao on 7/5/2018.
 * log format: id (alphanumeric) + " " + words or numbers
 * sort by: if words, then sort lexicographically, if words same, then sort by id
 * if numbers remain the same order and push to the end
 */
public class CustomSort {

    public static void main(String[] args) {
        CustomSort cs = new CustomSort();
        List<String> log = Arrays.asList(
                "xmnPPK0jLw EOeVIpuaqr",
                "5BAwDeyZ2F BMoDqxdjNY",
                "JDolrhMG4V hvMOOUrPDQ",
                "DVnljPgEfR TWdjEFEmUu",
                "aM5B3gyGT4 lhoUPzWFFj",
                "2jCB6MLpLU 8999956364",
                "laoRrYZQVQ 2237981932",

                "b9e9sj5IwF eokLtqmPBj",
                "o5KLJeIzNR eokLtqmPBj",
                "kySk2uZNQZ eokLtqmPBj",
                "osmYWT9BTY eokLtqmPBj",
                "ZC0LysrfIv eokLtqmPBj",

                "NodrCTs76Q 3462812486",
                "KFZ9zjOJtL 0414076761",
                "JIqo6tT6DV nttYPVsxqx",
                "FSgtd7c4rM dxufgfeIoL",
                "b38hiayfSl IQqkyNoDNh",
                "xeToGJ9aQq DydXUUnOEj",
                "4lWySsQDoS eokLtqmPBj",
                "A0Q8bgH5Lf msjIZQCTGM",
                "sVgGk4NGBp 8608867034",
                "znxxtJ8Fmt 3967374429",
                "FdFd7HufVr 5689558456",
                "9QjG5XDKBr 7133019161",
                "w7Ebqh8crc 7062044112"
        );

        for(String s: log){
            System.out.println(s);
        }

        List<String> reorderedLog = cs.reorderLines(log.size(), log);

        System.out.println("========");
        for(String s: reorderedLog){
            System.out.println(s);
        }

    }


    public List<String> reorderLines(int logFileSize, List<String> logLines){
        List<WordLog> wordLogs = new ArrayList<WordLog>();
        List<String> numberLogs = new ArrayList<String>();

        for(String logLine: logLines){
            int index = logLine.indexOf(' ');
            if(index == -1){
                //no space found, invalid line
                continue;
            }
            String id = logLine.substring(0, index);
            String body = logLine.substring(index + 1);
            if(body.matches("[a-zA-Z]*")){
                wordLogs.add(new WordLog(id, body));
            }
            else {
                numberLogs.add(logLine);
            }
        }

        Collections.sort(wordLogs);

        List<String> orderedLog = new ArrayList<String>();
        for(WordLog log: wordLogs){
            orderedLog.add(log.m_id + " " + log.m_body);
        }
        orderedLog.addAll(numberLogs);
        return orderedLog;
    }


}

class WordLog implements Comparable<WordLog> {
    public String m_id;
    public String m_body;

    public WordLog(String id, String body){
        m_id = id;
        m_body = body;
    }

    public int compareTo(WordLog other){
        if(this.m_body.equals(other.m_body)){
            //compare id
            return this.m_id.compareTo(other.m_id);
        }
        else {
            return this.m_body.compareTo(other.m_body);
        }
    }

}

