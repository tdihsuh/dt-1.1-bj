package cn.com.cycredit.hadoop.score;

public class Test {
    public static void  main(String[] args){
        String str = "[[row1/infos:name/1516621949316/Put/vlen=8/拘留seqid=0]][[row1/infos:name/1516621947068/Put拘留/vlen=8/seqid=0]]" +
                "[[row1/infos:name/1516621940400/Put/vlen=7/seqid=0]][[row1/infos:score/1516671938797/Put/vlen=1/seqid=0]][[row1/others:beizhu/1516623273814/Put/vlen=1/seqid=0]][[row1/others:beizhu/1516623270419/Put/vlen=1/seqid=0]][[row1/others:beizhu/1516623188168/Put/vlen=1/seqid=0]][[row1/others:beizhu/1516623185998/Put/vlen=1/seqid=0]][[row1/others:beizhu/1516623182376/Put/vlen=1/seqid=0]]";
        String a = "[[row1/infos:name/1516621949316/Put/vlen=8/seqid=0]],[[row1/infos:name/1516621949316/Put/vlen=8/seqid=0]]";
        int topicScore = ScanFromHBase.getTopicScore(str, "infos:name", new String[]{"ELSE", "警告", "拘留"}, new int[]{5, 1, 6});
        System.out.println(topicScore);
    }
}
