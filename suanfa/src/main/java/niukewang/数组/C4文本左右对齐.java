package niukewang.数组;

import java.util.ArrayList;
import java.util.List;

public class C4文本左右对齐 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int[] wordLengths=new int[words.length];
        for(int i=0;i<words.length;i++){
            wordLengths[i]=words[i].length();
        }
        List<List<String>> lists=new ArrayList<>();
        List<String> temp=new ArrayList();
        int curTempLength=0;
        int index=0;
        int i=0;
        while(i<wordLengths.length){
            curTempLength+=wordLengths[i];
            if(index!=0){
                curTempLength++;
            }
            if(curTempLength<=maxWidth){
                temp.add(words[i]);
                index++;
                i++;
            }else{
                lists.add(temp);
                temp=new ArrayList();
                curTempLength=0;
                index=0;
            }
        }
        lists.add(temp);

        List<String> r=adjuest(lists,maxWidth);

        return r;

    }

    public List<String> adjuest(List<List<String>> list,int maxWidth){
        List<String> result =new ArrayList();
        for(int i=0;i<list.size();i++){
            List<String> temp=list.get(i);
            int totalLength=0;
            for(int j=0;j<temp.size();j++){
                totalLength+=temp.get(j).length();
                if(j!=0){
                    totalLength++;
                }
            }
            int diff=maxWidth-totalLength;
            int[] buchong=new int[temp.size()-1];
            if(temp.size()==1){
                result.add(temp.get(0));
                continue;
            }
            int jun=diff/(temp.size()-1);
            int yu=diff%(temp.size()-1);
            for(int w=0;w<buchong.length;w++){
                buchong[w]=jun;
                if(yu<=w-1){
                    buchong[w]++;
                }
            }
            StringBuilder sb=new StringBuilder();
            for(int t=0;t<temp.size();t++){
                if(t!=0){
                    sb.append("_");
                }
                sb.append(temp.get(t));
                if(t!=temp.size()-1){
                    for(int m=0;m<buchong[t];m++){
                        sb.append("_");
                    }
                }


            }
            result.add(sb.toString());

        }

        return result;
    }

    public static void main(String[] args) {
        C4文本左右对齐 st=new C4文本左右对齐();
        String[] words={"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result = st.fullJustify(words,16);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i).length());
        }
    }


}
