/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter ;
import java.util.Random;
/**
 *
 * @author wi7
 */
public class Block {

    public int index ;    // number of block
    public String timeStamp ;   // emty el block created
    private String prev_hash ;
    private  String trans ; // data is an Amount
    private String Block_hash ;
    public String hash;

    Block(int index, String timeStamp ,String prev_hash,String trans)
    {
        this.index=index;
        this.timeStamp= timeStamp ;
        this.prev_hash=prev_hash ;
        this.trans=trans ;
    }
    public  String Calculate_Hash(byte[] bb)
    {
//        Object[] content ={Arrays.hashCode(trans), prev_hash };
//       return(   this.Block_hash=Arrays.hashCode(content) ) ;
        String hash_value="";
        String str2="SHA-256" ;
        try
        {
            MessageDigest message=MessageDigest.getInstance(str2);
            message.update(bb);
            byte[] digestedBytes=message.digest();
            hash_value=DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        }
        catch(Exception e) {}
        return hash_value ;
    }

    public String GetPrev_hash()
    {
        return prev_hash ;
    }
    public byte[] Get_trans()
    {
        String s=trans ;
        return (s.getBytes());
    }
    public String Get_BlockHash()
    {
        return Block_hash ;
    }

    public String Mining (int numberOfZeros)
    {
        String s="";
        for(int i= 0;i<numberOfZeros;i++)
        {
            s+="0";
        }
        while (this.hash.substring(0,numberOfZeros)!=s)
        {
            Random r = new Random();
            int result = r.nextInt(10000-1) + 1;

            byte bb [] = new byte[result];

            for (int i = 0; i < bb.length; i++) {
                double random = Math.random();
                System.out.println(Math.round(random));
            }

            this.hash=this.Calculate_Hash(bb);
        }

        return this.hash;
    }

//      public int Get_Hash(int x) {
//
//      }

}
