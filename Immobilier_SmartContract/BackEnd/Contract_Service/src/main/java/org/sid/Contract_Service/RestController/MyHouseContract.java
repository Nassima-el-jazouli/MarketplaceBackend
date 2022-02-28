package org.sid.Contract_Service.RestController;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class MyHouseContract extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600181905550611358806100686000396000f3fe6080604052600436106100705760003560e01c8063cdf4b8311161004e578063cdf4b831146100fb578063d0bec0ba1461013b578063e40b51a714610164578063e9970747146101a457610070565b80634ac1f783146100755780638da5cb5b146100a0578063b3f40d6a146100cb575b600080fd5b34801561008157600080fd5b5061008a6101e1565b6040516100979190610cc2565b60405180910390f35b3480156100ac57600080fd5b506100b56101e7565b6040516100c29190610d1e565b60405180910390f35b6100e560048036038101906100e09190610db7565b61020b565b6040516100f29190610e12565b60405180910390f35b34801561010757600080fd5b50610122600480360381019061011d9190610e59565b610669565b6040516101329493929190610f32565b60405180910390f35b34801561014757600080fd5b50610162600480360381019061015d91906110b3565b61075e565b005b34801561017057600080fd5b5061018b60048036038101906101869190610e59565b61092b565b60405161019b9493929190611122565b60405180910390f35b3480156101b057600080fd5b506101cb60048036038101906101c6919061116e565b610b7a565b6040516101d89190610cc2565b60405180910390f35b60015481565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600090505b600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208054905081101561065d5782600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002082815481106102af576102ae61119b565b5b906000526020600020906004020160030154141561064a57600060405180608001604052808673ffffffffffffffffffffffffffffffffffffffff168152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106103415761034061119b565b5b9060005260206000209060040201600101805461035d906111f9565b80601f0160208091040260200160405190810160405280929190818152602001828054610389906111f9565b80156103d65780601f106103ab576101008083540402835291602001916103d6565b820191906000526020600020905b8154815290600101906020018083116103b957829003601f168201915b50505050508152602001600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002084815481106104315761043061119b565b5b9060005260206000209060040201600201548152602001858152509050600260008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081908060018154018082558091505060019003906000526020600020906004020160009091909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101908051906020019061051a929190610bc6565b5060408201518160020155606082015181600301555050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002082815481106105825761058161119b565b5b9060005260206000209060040201600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556001820160006105c89190610c4c565b6002820160009055600382016000905550508473ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef866040516106379190610cc2565b60405180910390a3600192505050610663565b80806106559061125a565b915050610213565b50600090505b92915050565b6002602052816000526040600020818154811061068557600080fd5b9060005260206000209060040201600091509150508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060010180546106cf906111f9565b80601f01602080910402602001604051908101604052809291908181526020018280546106fb906111f9565b80156107485780601f1061071d57610100808354040283529160200191610748565b820191906000526020600020905b81548152906001019060200180831161072b57829003601f168201915b5050505050908060020154908060030154905084565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146107b657600080fd5b600180546107c491906112a3565b600181905550600060405180608001604052808573ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018381526020016001548152509050600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081908060018154018082558091505060019003906000526020600020906004020160009091909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190805190602001906108d3929190610bc6565b50604082015181600201556060820151816003015550507f2728c9d3205d667bbc0eefdfeda366261b4d021949630c047f3e5834b30611ab3360015460405161091d9291906112f9565b60405180910390a150505050565b60606000806000600260008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002085815481106109835761098261119b565b5b9060005260206000209060040201600101600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002086815481106109e5576109e461119b565b5b906000526020600020906004020160020154600260008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208781548110610a4857610a4761119b565b5b906000526020600020906004020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600260008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208881548110610acb57610aca61119b565b5b906000526020600020906004020160030154838054610ae9906111f9565b80601f0160208091040260200160405190810160405280929190818152602001828054610b15906111f9565b8015610b625780601f10610b3757610100808354040283529160200191610b62565b820191906000526020600020905b815481529060010190602001808311610b4557829003601f168201915b50505050509350935093509350935092959194509250565b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805490509050919050565b828054610bd2906111f9565b90600052602060002090601f016020900481019282610bf45760008555610c3b565b82601f10610c0d57805160ff1916838001178555610c3b565b82800160010185558215610c3b579182015b82811115610c3a578251825591602001919060010190610c1f565b5b509050610c489190610c8c565b5090565b508054610c58906111f9565b6000825580601f10610c6a5750610c89565b601f016020900490600052602060002090810190610c889190610c8c565b5b50565b5b80821115610ca5576000816000905550600101610c8d565b5090565b6000819050919050565b610cbc81610ca9565b82525050565b6000602082019050610cd76000830184610cb3565b92915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000610d0882610cdd565b9050919050565b610d1881610cfd565b82525050565b6000602082019050610d336000830184610d0f565b92915050565b6000604051905090565b600080fd5b600080fd5b6000610d5882610cdd565b9050919050565b610d6881610d4d565b8114610d7357600080fd5b50565b600081359050610d8581610d5f565b92915050565b610d9481610ca9565b8114610d9f57600080fd5b50565b600081359050610db181610d8b565b92915050565b60008060408385031215610dce57610dcd610d43565b5b6000610ddc85828601610d76565b9250506020610ded85828601610da2565b9150509250929050565b60008115159050919050565b610e0c81610df7565b82525050565b6000602082019050610e276000830184610e03565b92915050565b610e3681610cfd565b8114610e4157600080fd5b50565b600081359050610e5381610e2d565b92915050565b60008060408385031215610e7057610e6f610d43565b5b6000610e7e85828601610e44565b9250506020610e8f85828601610da2565b9150509250929050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610ed3578082015181840152602081019050610eb8565b83811115610ee2576000848401525b50505050565b6000601f19601f8301169050919050565b6000610f0482610e99565b610f0e8185610ea4565b9350610f1e818560208601610eb5565b610f2781610ee8565b840191505092915050565b6000608082019050610f476000830187610d0f565b8181036020830152610f598186610ef9565b9050610f686040830185610cb3565b610f756060830184610cb3565b95945050505050565b600080fd5b600080fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610fc082610ee8565b810181811067ffffffffffffffff82111715610fdf57610fde610f88565b5b80604052505050565b6000610ff2610d39565b9050610ffe8282610fb7565b919050565b600067ffffffffffffffff82111561101e5761101d610f88565b5b61102782610ee8565b9050602081019050919050565b82818337600083830152505050565b600061105661105184611003565b610fe8565b90508281526020810184848401111561107257611071610f83565b5b61107d848285611034565b509392505050565b600082601f83011261109a57611099610f7e565b5b81356110aa848260208601611043565b91505092915050565b6000806000606084860312156110cc576110cb610d43565b5b60006110da86828701610e44565b935050602084013567ffffffffffffffff8111156110fb576110fa610d48565b5b61110786828701611085565b925050604061111886828701610da2565b9150509250925092565b6000608082019050818103600083015261113c8187610ef9565b905061114b6020830186610cb3565b6111586040830185610d0f565b6111656060830184610cb3565b95945050505050565b60006020828403121561118457611183610d43565b5b600061119284828501610e44565b91505092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061121157607f821691505b60208210811415611225576112246111ca565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b600061126582610ca9565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8214156112985761129761122b565b5b600182019050919050565b60006112ae82610ca9565b91506112b983610ca9565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff038211156112ee576112ed61122b565b5b828201905092915050565b600060408201905061130e6000830185610d0f565b61131b6020830184610cb3565b939250505056fea264697066735822122021f008711eaddc7ab4177e0740e6a3894b44b76c2d3030b87e7aa1b23f0bfe3f64736f6c634300080a0033";

    public static final String FUNC___OWNEDHOUSES = "__ownedHouses";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_TOTALHOUSESCOUNTER = "totalHousesCounter";

    public static final String FUNC_ADDHOUSE = "addHouse";

    public static final String FUNC_TRANSFERLAND = "transferLand";

    public static final String FUNC_GETHOUSE = "getHouse";

    public static final String FUNC_GETNOMBREOFHOUSES = "getNombreOfHouses";

    public static final Event ADD_EVENT = new Event("Add",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ETHERTRANSFER_EVENT = new Event("EtherTransfer",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected MyHouseContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyHouseContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MyHouseContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MyHouseContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddEventResponse> getAddEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADD_EVENT, transactionReceipt);
        ArrayList<AddEventResponse> responses = new ArrayList<AddEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddEventResponse typedResponse = new AddEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._HouseID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddEventResponse> addEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddEventResponse>() {
            @Override
            public AddEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADD_EVENT, log);
                AddEventResponse typedResponse = new AddEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._HouseID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddEventResponse> addEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADD_EVENT));
        return addEventFlowable(filter);
    }

    public List<EtherTransferEventResponse> getEtherTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ETHERTRANSFER_EVENT, transactionReceipt);
        ArrayList<EtherTransferEventResponse> responses = new ArrayList<EtherTransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EtherTransferEventResponse typedResponse = new EtherTransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._cost = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EtherTransferEventResponse> etherTransferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, EtherTransferEventResponse>() {
            @Override
            public EtherTransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ETHERTRANSFER_EVENT, log);
                EtherTransferEventResponse typedResponse = new EtherTransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._cost = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<EtherTransferEventResponse> etherTransferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ETHERTRANSFER_EVENT));
        return etherTransferEventFlowable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._HouseID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._HouseID = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<Tuple4<String, String, BigInteger, BigInteger>> __ownedHouses(String param0, BigInteger param1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC___OWNEDHOUSES,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0),
                        new org.web3j.abi.datatypes.generated.Uint256(param1)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<String, String, BigInteger, BigInteger>>(function,
                new Callable<Tuple4<String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(),
                                (String) results.get(1).getValue(),
                                (BigInteger) results.get(2).getValue(),
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalHousesCounter() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALHOUSESCOUNTER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addHouse(String propertyOwner, String _location, BigInteger _cost) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDHOUSE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(propertyOwner),
                        new org.web3j.abi.datatypes.Utf8String(_location),
                        new org.web3j.abi.datatypes.generated.Uint256(_cost)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferLand(String _HouseBuyer, BigInteger _HouseID) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERLAND,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_HouseBuyer),
                        new org.web3j.abi.datatypes.generated.Uint256(_HouseID)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple4<String, BigInteger, String, BigInteger>> getHouse(String _HouseHolder, BigInteger _index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETHOUSE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_HouseHolder),
                        new org.web3j.abi.datatypes.generated.Uint256(_index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<String, BigInteger, String, BigInteger>>(function,
                new Callable<Tuple4<String, BigInteger, String, BigInteger>>() {
                    @Override
                    public Tuple4<String, BigInteger, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, BigInteger, String, BigInteger>(
                                (String) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue(),
                                (String) results.get(2).getValue(),
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getNombreOfHouses(String _HouseHolder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNOMBREOFHOUSES,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_HouseHolder)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static MyHouseContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyHouseContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MyHouseContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyHouseContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MyHouseContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MyHouseContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MyHouseContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MyHouseContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MyHouseContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyHouseContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<MyHouseContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyHouseContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyHouseContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyHouseContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyHouseContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyHouseContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class AddEventResponse extends BaseEventResponse {
        public String _owner;

        public BigInteger _HouseID;
    }

    public static class EtherTransferEventResponse extends BaseEventResponse {
        public String _from;

        public String _to;

        public BigInteger _cost;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String _from;

        public String _to;

        public BigInteger _HouseID;
    }
}
