// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;


contract MyHouseContract
{

    // function withdrowMoney(address payable _to , uint _amount) public payable {
    //     _to.transfer(_amount);

    //     }


    // function withdraw()  public {
    //     msg.sender.transfer(address(this).balance);
    // }

    // function deposit(uint256 amount) payable public {
    //     require(msg.value == amount);
    // }
    // function getBalance() public view returns (uint256) {
    //     return address(this).balance;
    // }



    struct House
    {
        address ownerAddress;
        string location;
        uint cost;
        uint HouseID;
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
    mapping (address => uint) balances;
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
        HouseID: totalHousesCounter
        });
        __ownedHouses[msg.sender].push(myHouse);
        emit Add(msg.sender, totalHousesCounter);

    }


    // Errors allow you to provide information about
    // why an operation failed. They are returned
    // to the caller of the function.
    // error InsufficientBalance(uint requested, uint available);

    // // Sends an amount of existing coins
    // // from any caller to an address
    // function transferEther(address receiver, uint amount) public {
    //     if (amount > balances[msg.sender])
    //         revert InsufficientBalance({
    //         requested: amount,
    //         available: balances[msg.sender]
    //         });

    //     balances[msg.sender] -= amount;
    //     balances[receiver] += amount;
    //     emit EtherTransfer(msg.sender, receiver, amount);
    // }


    //2. SECOND OP\\ERATION
    //caller (owner/anyone) to transfer House to buyer provided caller is owner of the House
    function transferLand(address payable  _HouseBuyer, uint _HouseID) payable public returns (bool)
    {
        //deposit(40);
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
                HouseID: _HouseID
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
    function getHouse(address _HouseHolder, uint _index) public view  returns (string memory, uint, address,uint)
    {

        return (__ownedHouses[_HouseHolder][_index].location,
        __ownedHouses[_HouseHolder][_index].cost,
        __ownedHouses[_HouseHolder][_index].ownerAddress,
        __ownedHouses[_HouseHolder][_index].HouseID
        );

    }

    //4. GET TOTAL NOMBRE OF Houses OWNED BY AN ACCOUNT AS NO WAY TO RETURN STRUCT ARRAYS
    function getNombreOfHouses(address _HouseHolder) public view returns (uint)
    {
        return __ownedHouses[_HouseHolder].length;
    }


}