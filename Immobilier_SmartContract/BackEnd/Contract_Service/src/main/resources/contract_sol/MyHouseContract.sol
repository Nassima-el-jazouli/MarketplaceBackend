// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract MyHouseContract
{
    struct House
    {
        address ownerAddress;
        string location;
        uint cost;
        uint HouseID;
        uint wantSell;
    }

    address public owner;   // government who creates the contract
    uint public totalHousesCounter; //total number of Houses via this contract at any time

    //define who is owner
    //function MyLandContract() public
    constructor()
    {
        owner = msg.sender;
        totalHousesCounter = 0;
    }

    //House addition event
    event Add(address _owner, uint _HouseID);
    //House transfer event
    event Transfer(address indexed _from, address indexed _to, uint _HouseID);
    // House Ether Transfer
    event EtherTransfer(address indexed _from, address indexed _to, uint _cost);

    modifier isOwner
    {
        require(msg.sender == owner);
        _;
    }

    //one account can hold many Houses (many landTokens, each token one House)
    mapping (address => House[]) public __ownedHouses;
    mapping (address => uint) public balances;
    //properties to be sold


    //1. FIRST OPERATION
    //owner shall add Houses via this function
    function addHouse(address propertyOwner,string memory _location, uint _cost) public isOwner
    {
        totalHousesCounter = totalHousesCounter + 1;
        House memory myHouse = House(
        {
        ownerAddress: propertyOwner,
        location: _location,
        cost: _cost,
        HouseID: totalHousesCounter,
        wantSell: 1

        });
        __ownedHouses[msg.sender].push(myHouse);
        emit Add(msg.sender, totalHousesCounter);

    }

    // TRANSFER ETHER
/*
    function transferEther(address  rec,uint _amount) public payable {
        payable (address(rec)).transfer(_amount);
    }

    function withdraw() public  payable {
        payable(msg.sender).transfer(address(this).balance);
    }
*/

    // Errors allow you to provide information about
    // why an operation failed. They are returned
    // to the caller of the function.
    error InsufficientBalance(uint requested, uint available);

    // Sends an amount of existing coins
    // from any caller to an address
    function transferEther(address receiver, uint amount) public {  // TO CHANGER!!!!!!! ADD  SENDER ADDRESS
        if (amount > balances[msg.sender])
            revert InsufficientBalance({
            requested: amount,
            available: balances[msg.sender]
            });

        balances[msg.sender] -= amount;
        balances[receiver] += amount;
        emit EtherTransfer(msg.sender, receiver, amount);
    }


    //2. SECOND OP\\ERATION
    //caller (owner/anyone) to transfer House to buyer provided caller is owner of the House
    function transferLand(address _HouseBuyer, uint _HouseID) payable public returns (bool)
    {
        //find out the particular land ID in owner's collectionexter
        for(uint i=0; i < (__ownedHouses[msg.sender].length);i++)
        {
            //if given House ID is indeed in owner's collection
            if (__ownedHouses[msg.sender][i].HouseID == _HouseID)
            {

                //copy House in new owner's collection
                House memory myHouse = House(
                {
                ownerAddress:_HouseBuyer,
                location: __ownedHouses[msg.sender][i].location,
                cost: __ownedHouses[msg.sender][i].cost,
                HouseID: _HouseID,
                wantSell: __ownedHouses[msg.sender][i].wantSell
                });
                __ownedHouses[_HouseBuyer].push(myHouse);

                //remove House from current ownerAddress
                delete __ownedHouses[msg.sender][i];


                //inform the world
                emit Transfer(msg.sender, _HouseBuyer, _HouseID);

                return true;
            }
        }

        //if we still did not return, return false
        return false;
    }


    //3. THIRD OPERATION
    //get House details of an account
    function getHouse(address _HouseHolder, uint _index) public view  returns (string memory, uint, address,uint, uint)
    {
        return (__ownedHouses[_HouseHolder][_index].location,
        __ownedHouses[_HouseHolder][_index].cost,
        __ownedHouses[_HouseHolder][_index].ownerAddress,
        __ownedHouses[_HouseHolder][_index].HouseID,
        __ownedHouses[_HouseHolder][_index].wantSell
        );

    }

    // REMOVE House FROM SALE

    function RemoveHouseFromSale(address _HouseHolder, uint _House_id) public returns (string memory){

        uint indexer;

        for(indexer=0; indexer < (__ownedHouses[_HouseHolder].length);indexer++){
            if ( __ownedHouses[_HouseHolder][indexer].HouseID == _House_id ){
                if ( __ownedHouses[_HouseHolder][indexer].wantSell == 1 ){
                    __ownedHouses[_HouseHolder][indexer].wantSell=0;
                    return "OPERATION SUCCESSFULL";
                }else{
                    return "PROPERTY ALREADY NOT FOR SALE";
                }
            }
        }

        return "INVALID House ID";
    }

    //4. GET TOTAL NOMBRE OF Houses OWNED BY AN ACCOUNT AS NO WAY TO RETURN STRUCT ARRAYS
    function getNumberOfHouses(address _HouseHolder) public view returns (uint)
    {
        return __ownedHouses[_HouseHolder].length;
    }


}