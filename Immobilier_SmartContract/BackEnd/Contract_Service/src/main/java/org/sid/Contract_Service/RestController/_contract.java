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
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
public class _contract extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610ec3806100606000396000f3fe60806040526004361061003f5760003560e01c8063887b021b146100445780638da5cb5b14610074578063937abe961461009f578063cdf4b831146100c8575b600080fd5b61005e60048036038101906100599190610a29565b610106565b60405161006b9190610aa0565b60405180910390f35b34801561008057600080fd5b506100896104ed565b6040516100969190610adc565b60405180910390f35b3480156100ab57600080fd5b506100c660048036038101906100c19190610b23565b610511565b005b3480156100d457600080fd5b506100ef60048036038101906100ea9190610bb5565b6106a5565b6040516100fd929190610c7d565b60405180910390f35b600080600090505b600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020805490508110156104e1578280519060200120600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002082815481106101b1576101b0610cad565b5b90600052602060002090600202016001016040516101cf9190610ddc565b604051809103902014156104ce57600060405180604001604052808673ffffffffffffffffffffffffffffffffffffffff168152602001600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020848154811061025757610256610cad565b5b9060005260206000209060020201600101805461027390610d0b565b80601f016020809104026020016040519081016040528092919081815260200182805461029f90610d0b565b80156102ec5780601f106102c1576101008083540402835291602001916102ec565b820191906000526020600020905b8154815290600101906020018083116102cf57829003601f168201915b50505050508152509050600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081908060018154018082558091505060019003906000526020600020906002020160009091909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010190805190602001906103c292919061078e565b505050600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020828154811061041657610415610cad565b5b9060005260206000209060020201600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905560018201600061045c9190610814565b50508473ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f55e10366a5f552746106978b694d7ef3bbddec06bd5f9b9d15ad46f475c653ef866040516104bb9190610df3565b60405180910390a36001925050506104e7565b80806104d990610e44565b91505061010e565b50600090505b92915050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461056957600080fd5b600060405180604001604052808473ffffffffffffffffffffffffffffffffffffffff168152602001838152509050600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081908060018154018082558091505060019003906000526020600020906002020160009091909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101908051906020019061066492919061078e565b5050507f642fae9d0bdca764daf250fc90831d6e88318a4ce78836d46fbbf63c282c6c208383604051610698929190610c7d565b60405180910390a1505050565b600160205281600052604060002081815481106106c157600080fd5b9060005260206000209060020201600091509150508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169080600101805461070b90610d0b565b80601f016020809104026020016040519081016040528092919081815260200182805461073790610d0b565b80156107845780601f1061075957610100808354040283529160200191610784565b820191906000526020600020905b81548152906001019060200180831161076757829003601f168201915b5050505050905082565b82805461079a90610d0b565b90600052602060002090601f0160209004810192826107bc5760008555610803565b82601f106107d557805160ff1916838001178555610803565b82800160010185558215610803579182015b828111156108025782518255916020019190600101906107e7565b5b5090506108109190610854565b5090565b50805461082090610d0b565b6000825580601f106108325750610851565b601f0160209004906000526020600020908101906108509190610854565b5b50565b5b8082111561086d576000816000905550600101610855565b5090565b6000604051905090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006108b082610885565b9050919050565b6108c0816108a5565b81146108cb57600080fd5b50565b6000813590506108dd816108b7565b92915050565b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610936826108ed565b810181811067ffffffffffffffff82111715610955576109546108fe565b5b80604052505050565b6000610968610871565b9050610974828261092d565b919050565b600067ffffffffffffffff821115610994576109936108fe565b5b61099d826108ed565b9050602081019050919050565b82818337600083830152505050565b60006109cc6109c784610979565b61095e565b9050828152602081018484840111156109e8576109e76108e8565b5b6109f38482856109aa565b509392505050565b600082601f830112610a1057610a0f6108e3565b5b8135610a208482602086016109b9565b91505092915050565b60008060408385031215610a4057610a3f61087b565b5b6000610a4e858286016108ce565b925050602083013567ffffffffffffffff811115610a6f57610a6e610880565b5b610a7b858286016109fb565b9150509250929050565b60008115159050919050565b610a9a81610a85565b82525050565b6000602082019050610ab56000830184610a91565b92915050565b6000610ac682610885565b9050919050565b610ad681610abb565b82525050565b6000602082019050610af16000830184610acd565b92915050565b610b0081610abb565b8114610b0b57600080fd5b50565b600081359050610b1d81610af7565b92915050565b60008060408385031215610b3a57610b3961087b565b5b6000610b4885828601610b0e565b925050602083013567ffffffffffffffff811115610b6957610b68610880565b5b610b75858286016109fb565b9150509250929050565b6000819050919050565b610b9281610b7f565b8114610b9d57600080fd5b50565b600081359050610baf81610b89565b92915050565b60008060408385031215610bcc57610bcb61087b565b5b6000610bda85828601610b0e565b9250506020610beb85828601610ba0565b9150509250929050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610c2f578082015181840152602081019050610c14565b83811115610c3e576000848401525b50505050565b6000610c4f82610bf5565b610c598185610c00565b9350610c69818560208601610c11565b610c72816108ed565b840191505092915050565b6000604082019050610c926000830185610acd565b8181036020830152610ca48184610c44565b90509392505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60006002820490506001821680610d2357607f821691505b60208210811415610d3757610d36610cdc565b5b50919050565b600081905092915050565b60008190508160005260206000209050919050565b60008154610d6a81610d0b565b610d748186610d3d565b94506001821660008114610d8f5760018114610da057610dd3565b60ff19831686528186019350610dd3565b610da985610d48565b60005b83811015610dcb57815481890152600182019150602081019050610dac565b838801955050505b50505092915050565b6000610de88284610d5d565b915081905092915050565b60006020820190508181036000830152610e0d8184610c44565b905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000610e4f82610b7f565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff821415610e8257610e81610e15565b5b60018201905091905056fea2646970667358221220c41541fb97c84a5ce3ed63d4f50b122b32aeb502d7d58470a12303a153ac4d2364736f6c634300080a0033";

    public static final String FUNC___OWNEDHOUSES = "__ownedHouses";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADDHOUSE = "addHouse";

    public static final String FUNC_TRANSFERLAND = "transferLand";

    public static final Event ADD_EVENT = new Event("Add",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected _contract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected _contract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected _contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected _contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddEventResponse> getAddEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADD_EVENT, transactionReceipt);
        ArrayList<AddEventResponse> responses = new ArrayList<AddEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddEventResponse typedResponse = new AddEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.title = (String) eventValues.getNonIndexedValues().get(1).getValue();
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
                typedResponse.title = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddEventResponse> addEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADD_EVENT));
        return addEventFlowable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.title = (String) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.title = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<Tuple2<String, String>> __ownedHouses(String param0, BigInteger param1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC___OWNEDHOUSES,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0),
                        new org.web3j.abi.datatypes.generated.Uint256(param1)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple2<String, String>>(function,
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(),
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addHouse(String propertyOwner, String _title) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDHOUSE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(propertyOwner),
                        new org.web3j.abi.datatypes.Utf8String(_title)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferLand(String _HouseBuyer, String _title) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERLAND,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_HouseBuyer),
                        new org.web3j.abi.datatypes.Utf8String(_title)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static _contract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new _contract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static _contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new _contract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static _contract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new _contract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static _contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new _contract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<_contract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(_contract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<_contract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(_contract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<_contract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(_contract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<_contract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(_contract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class AddEventResponse extends BaseEventResponse {
        public String _owner;

        public String title;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String _from;

        public String _to;

        public String title;
    }
}
