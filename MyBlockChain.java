import java.util.ArrayList;
import java.util.Arrays ;
import java.text.SimpleDateFormat ;

public class MyBlockChain {

    public static ArrayList<Block > Chain= new ArrayList() ;

    public class MyChain
    {
        public void Create_genesisBlock()
        {
            String  transaction="yamana sends 100 bitcoin " ;
            Block b ;
            b = new Block(0,"1/1/2018","0",transaction );

            Chain.add(b);
        }
        MyChain()
        {
            Create_genesisBlock();
        }

        public void Add_Block(Block bb)
        {
            bb.Mining(5);
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

}
