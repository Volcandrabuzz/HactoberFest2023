class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        List<String> w2=new ArrayList<>();
        for(int i=0;i<words2.length;i++){
            w2.add(words2[i]);
        }
        
        for(int j=0;j<words1.length;j++){
            List<String> last=listsub(words1[j]);
            if(last.containsAll(w2)){
                list.add(words1[j]);
            }
        }
        return list;
        
    }

    public static List<String> listsub(String str) {
        List<String> arr=new ArrayList<>();
        subsets(str,0,"",arr);
        return arr;

    }

    public static void subsets(String str,int idx,String newstr,List<String> arr){
        List<String> work=new ArrayList<>();
        if(idx==str.length()){
            arr.add(newstr);
            
            permutation(newstr,arr);
            return;
        }
        char current=str.charAt(idx);
        subsets(str,idx+1,newstr+current,arr);
        subsets(str,idx+1,newstr,arr);
    }
    public static List<String> permutation(String newstr,List<String> arr){
        perm(newstr,"",arr);
        return arr;
    }

    public static void perm(String newstr,String p,List<String> arr){
        if(newstr.length()==0){
            arr.add(p);
            return;
        }
        for(int i=0;i<newstr.length();i++){
            char current=newstr.charAt(i);
            String hover=newstr.substring(0,i)+newstr.substring(i+1);
            perm(hover,p+current,arr);
        }
    }


}a
