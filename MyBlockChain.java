import java.util.ArrayList;
import java.util.Arrays ;
import java.text.SimpleDateFormat ;
import java.util.Scanner;

public class MyBlockChain {

    //ArrayList<Integer>[] A = (ArrayList<Integer>[])new ArrayList[n];
    public static ArrayList<Block>[] voting = new ArrayList[3];   // kda array of array list created
    public class MyChain
    {
        public  ArrayList<Block > Chain= new ArrayList() ;
        public void Create_genesisBlock()
        {
            String  transaction="yamana sends 100 bitcoin " ;
            Block b;
            b = new Block(0 ,"1/1/2018","0", transaction );

            Chain.add(b);
        }
        MyChain()
        {
            Create_genesisBlock();
        }

        public void Add_Block(Block bb)
        {
            // bb.Mining(5);
            Chain.add(bb);
        }

        public boolean IsValid()
        {
            for (int i=1; i<Chain.size() ;i++)
            {
                Block currentBlock=Chain.get(i);
                Block PreviousBlock=Chain.get(i-1);

                if(PreviousBlock.Get_BlockHash()!=currentBlock.GetPrev_hash())
                    return false ;
                if(currentBlock.Get_BlockHash()!= currentBlock.Calculate_Hash(currentBlock.Get_trans() )) {
                } else {
                    return false ;
                }
            }
            return true ;
        }
    }

    public static void main(String[] args) {
        Vote voter = new Vote();
        ArrayList<String> candidatesNames = new ArrayList();
        ArrayList<Integer> voterKeys = new ArrayList();

        boolean dublicate = false;
        candidatesNames.add("Nooran");
        candidatesNames.add("Hanaa");
        candidatesNames.add("Yamana");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter you public key: ");
        voter.Voter_key = input.nextInt();
        if (voterKeys.size() == 0)
            voterKeys.add(voter.Voter_key);
        else {
            for (int i = 0; i < voterKeys.size(); i++) {
                if (voter.Voter_key == voterKeys.get(i)) {
                    dublicate = true;
                    break;
                } else {
                    voterKeys.add(voter.Voter_key);
                    break;
                }
            }
        }
        System.out.println(voterKeys);
        if (!dublicate) {
            System.out.println("Enter number of your choice, 1- Nooran 2- Hanaa 3- Yamana");
            voter.choice = input.nextInt();
            int c = voter.choice;
            //byte c[]=voter.choice.getBytes();
            // to fill all data to  voter's block
         //   int s = voting[c - 1].size();
            // get previous hash ll block fe el chain d
            Block bb = new Block();
          //  bb.Mining(5);
            voting[c - 1].add(bb);
            //Add_Block(bb);
        } else {
            System.out.println("You have voted before!");
        }
        int max = voting[0].size();
        int idx=0;
        for (int x = 0; x < voting.length; x++) {
            if (voting[x].size() > max) {
                max = voting[x].size();
                idx = x + 1;
            }
        }
        System.out.println("winners is candidate num :"+ idx);

    }

//   String[] transactions={"yamana sends 100 bitcoin ","Murat sends 20 bitcoin to hayat"} ;
//    Block genesis_Block=new Block( 0,"3/3/2019",0 , transactions) ;
//
//    String[] transactions2={"Can sends 10 bitcoin ", "kemal sends 200 bitcoin to ferah"} ;
//    Block Block2=new Block(1,"10/3/2019",genesis_Block.Get_BlockHash()  , transactions2) ;
//    System.out.println("hash of genesis block ");
//    System.out.println(genesis_Block.Get_BlockHash()) ;
//    System.out.println("hash of block 2 ");
//    System.out.println(Block2.Get_BlockHash()) ;

    }
