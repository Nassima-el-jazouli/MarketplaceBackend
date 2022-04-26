/*
package org.sid.Contract_Service.RestController;

import org.sid.Contract_Service.entities.House;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
*/

/*
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Ethereum")
public class EthereumRestController {
*/

    //********************    ADMIN    *****************************//
/*

    private  final static  String PRIVATE_KEY="5fd24f9d9a1c114a3e15090a74fb25aae8350b9458302d96a0c90882104096bb";
    private final static BigInteger GAS_LIMIT =BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private  static String  CONTRACT_ADDRESS = "0xba0397c24da59e0d519a505e2434bfe101caf24a";

    Web3j web3j = Web3j.build( new HttpService("HTTP://127.0.0.1:8545"));
    TransactionManager transactionManager = new RawTransactionManager(
            web3j,getCredentialsFromPrivateKey() );
*/

  /*  @GetMapping(path = "/hello")
    public int hello() throws Exception {

        return 5;
    }

    @GetMapping("/DeployContract")
    public void  DeployContract() throws Exception {

        String deployedAddress = deployContract(web3j,transactionManager);
        CONTRACT_ADDRESS=deployedAddress;//we should add contract address to mongodb database to save it
        System.out.println("Deployed contract address :"+ CONTRACT_ADDRESS);
        System.out.println("**************************************************************");
    }*/

    //PostMapping
 /*   @GetMapping(path = "/AddHouse")
    public void AddHouse(@RequestParam(value = "ownerAddress") String ownerAddress,
                         @RequestParam(value = "location") String  location,
                         @RequestParam(value = "cost") Long cost) throws Exception {


        MyHouseContract loadAddress = loadContract(CONTRACT_ADDRESS,web3j,transactionManager);
        System.out.println("Deployed contract address :"+ loadAddress.getContractAddress());
        loadAddress.addHouse(ownerAddress,location,BigInteger.valueOf(cost)).send();

    }*/

    /* @GetMapping(value = "/transferLand")
     public void transferLand(@RequestParam(value = "HouseBuyer") String HouseBuyer,
                              @RequestParam(value = "HouseID") int HouseID) throws Exception {

         MyHouseContract loadAddress = loadContract(CONTRACT_ADDRESS,web3j,transactionManager);
         System.out.println("Deployed contract address :"+ loadAddress.getContractAddress());
         loadAddress.transferLand(HouseBuyer,BigInteger.valueOf(HouseID)).send();
         System.out.println("House Transfer Success to"+HouseBuyer);
     }*/

/*
    private Credentials getCredentialsFromPrivateKey(){
        return  Credentials.create(PRIVATE_KEY);
    }*/

    //*********************** deploy the smart contract en ethereum   *********************//

    /*private String deployContract(Web3j web3j,TransactionManager transactionManager) throws Exception {

       return MyHouseContract.deploy(web3j,transactionManager,GAS_PRICE,GAS_LIMIT).send().getContractAddress();

    }*/

    //*********************** load the smart contract en ethereum   *********************//

    /*private MyHouseContract loadContract(String contractAddress, Web3j web3j, TransactionManager transactionManager){
        //CONTRACT_ADDRESS
        return MyHouseContract.load(contractAddress,web3j,transactionManager,GAS_PRICE,GAS_LIMIT);


    }
*/


    //**************************************  END ADMIN********************************//



    //**************************************  Client ********************************//

    //@GetMapping(path = "/transferLand")

    //@GetMapping(path = "/getHouse")
    //@GetMapping(path = "/RemoveHouseFromSale")

   /* @GetMapping(path = "/LoadContract")
    public String LoadContract() throws Exception {
        MyContract loadAddress = loadContract(CONTRACT_ADDRESS,web3j,transactionManager);
        System.out.println("Deployed contract address :"+ loadAddress.getContractAddress());
        return "\nContract Address:     "+loadAddress.getContractAddress()+
                "\nContract Owner:      "+ loadAddress.get_owner()+
                "\nContract HouseTitle      "+loadAddress.get_HouseTitle().toString();
    }*/

    /*@GetMapping(value = "/transferEther")
    public void transferEther(@RequestParam(value = "receiver") String receiver ,
                              @RequestParam(value = "amount") Long amount ) throws Exception {

        MyHouseContract loadAddress = loadContract(CONTRACT_ADDRESS,web3j,transactionManager);
        System.out.println("Deployed contract address :"+ loadAddress.getContractAddress());
        //transfer on contract
        //loadAddress.transferEther(receiver,BigInteger.valueOf(amount));
        System.out.println("Sender amount is :"+loadAddress.balances("0x018163ea16FB109f143DDEAc22f402d41B86152f"));
        System.out.println("Receiver amount is :"+loadAddress.balances(receiver));

        //transfer on Ganache
        Transfer transfer =new Transfer(web3j,transactionManager);
        TransactionReceipt transactionReceipt = transfer.sendFunds(
                receiver, // amount receptor
                //BigDecimal.ONE,// amount to transfer
                BigDecimal.valueOf(amount),
                Convert.Unit.ETHER, // one ether
                GAS_PRICE,
                GAS_LIMIT
        ).send();

        System.out.println("transaction hash:"+transactionReceipt.getTransactionHash() );

    }*/

   /* @GetMapping(value = "/getNombreOfHouses")
    public BigInteger getNombreOfHouses(@RequestParam(value = "ownerAddress") String ownerAddress ) throws Exception {

        MyHouseContract loadAddress = loadContract(CONTRACT_ADDRESS,web3j,transactionManager);
        System.out.println("getNombreOfHouses ...");
        return loadAddress.getNombreOfHouses(ownerAddress).send();

    }

    @GetMapping(value = "/getHouse")
    public House getHouse(@RequestParam(value = "_HouseHolder") String _HouseHolder,
                           @RequestParam(value = "_index") int _index) throws Exception {

        MyHouseContract loadAddress = loadContract(CONTRACT_ADDRESS,web3j,transactionManager);
        System.out.println("getHouse ...");
        House house = new House();

        String location = loadAddress.getHouse(_HouseHolder,BigInteger.valueOf(_index)).send().getValue1();
        BigInteger Cost = loadAddress.getHouse(_HouseHolder,BigInteger.valueOf(_index)).send().getValue2();
        String OwnerAddress =loadAddress.getHouse(_HouseHolder,BigInteger.valueOf(_index)).send().getValue3();
        BigInteger HouseId = loadAddress.getHouse(_HouseHolder,BigInteger.valueOf(_index)).send().getValue4();


        house.setOwnerAddress(OwnerAddress);
        house.setLocation(location);
        house.setCost(Cost.doubleValue());
        house.setHouseID(HouseId.intValue());
*/
        //return loadAddress.getHouse(_HouseHolder,BigInteger.valueOf(_index)).send();
/*
        return  house;
    }

}
*/
