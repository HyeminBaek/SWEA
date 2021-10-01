import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
class Solution
{
    //global var for ps
    private static int K;
    private static ArrayList<Integer>[] list;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            K = Integer.parseInt(br.readLine());
             
            list = new ArrayList[4];
            for(int i=0;i<4;i++) list[i] = new ArrayList<Integer>();
             
            for(int i=0;i<4;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<8;j++) {
                    list[i].add(Integer.parseInt(st.nextToken()));
                }
            }//input
             
            for(int i=0;i<K;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()), dir = Integer.parseInt(st.nextToken());
                 
                rotate(num,dir);
                 
//              for(int x=0;x<4;x++) {
//                  for(int y=0;y<8;y++) System.out.print(list[x].get(y)+" ");
//                  System.out.println();
//              }
            }
             
            sb.append("#"+test_case+" "+solution()+"\n");
        }//tc
         
        System.out.println(sb);
    }//main
    private static int solution() {
        int score =0;
         
        for(int i=0;i<4;i++) {
            if(list[i].get(0)==1) score+=Math.pow(2.0, i);
        }
        return score;
    }
    private static void clockwise(int num) {
        //System.out.println(num);
        list[num].add(0,list[num].get(list[num].size()-1));
        list[num].remove(list[num].size()-1);
    }
    private static void anticlockwise(int num) {
        list[num].add(list[num].get(0));
        list[num].remove(0);
    }
    private static void rotate(int num,int dir) {
        //자석을 1 칸씩 회전시키는 회전 정보, 날의 자성은 N 극이 0 으로, S 극이 1 로 주어진다.
         
        if(dir == 1) clockwise(num-1); 
        else if(dir==-1) anticlockwise(num-1);
         
         
        //붙어 있는 자석은 서로 붙어 있는 날의 자성과 다를 경우에만 인력에 의해 반대 방향으로 1 칸 회전된다.
        //left 2-6 cur 2-right 6 
         
        //left
        if(num-1>0) {
            int curD=-dir;
            for(int i=num-2;i>=0;i--) {
                if(curD==-1) {
                    if(list[i].get(2)!=list[i+1].get(7)) anticlockwise(i);
                    else break;
                } else {
                    if(list[i].get(2)!=list[i+1].get(5)) clockwise(i);
                    else break;
                }
                 
                curD = -curD;
            }
        }
        //right
        if(num<4) {
            int curD=-dir;
            for(int i=num;i<4;i++) {
                if(curD==-1) {
                    if(list[i].get(6)!=list[i-1].get(3)) anticlockwise(i);
                    else break;
                } else {
                    if(list[i].get(6)!=list[i-1].get(1)) clockwise(i);
                    else break;
                }
                 
                curD = -curD;
            }
        }
    }
}
