// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;


contract MyHouseContract
{

    struct House
    {
        address ownerAddress;
        string title;
    }

    address public owner;   // government who creates the contract

    //define who is owner
    constructor()
    {
        owner = msg.sender;
    }

    //House addition event
    event Add(address _owner, string title);
    //House transfer event
    event Transfer(address indexed _from, address indexed _to, string title);

    modifier isOwner
    {
        require(msg.sender == owner);
        _;
    }

    //one account can hold many Houses (many landTokens, each token one House)
    mapping (address => House[]) public __ownedHouses;

    //owner shall add Houses via this function
    function addHouse(address propertyOwner,string memory _title) public isOwner
    {

        House memory myHouse = House(
        {
        ownerAddress: propertyOwner,
        title: _title
        });
        // __ownedHouses[msg.sender].push(myHouse);
        __ownedHouses[propertyOwner].push(myHouse);

        emit Add(propertyOwner, _title);

    }

    //caller (owner/anyone) to transfer House to buyer provided caller is owner of the House
    function transferLand(address payable  _HouseBuyer, string memory _title) payable public returns (bool)
    {
        for(uint i=0; i < (__ownedHouses[msg.sender].length);i++)
        {
            //if given House ID is indeed in owner's collection
            if (keccak256(bytes(__ownedHouses[msg.sender][i].title )) == keccak256(bytes(_title)))
            {

                //copy House in new owner's collection
                House memory myHouse = House(
                {
                ownerAddress:_HouseBuyer,
                title: __ownedHouses[msg.sender][i].title

                });
                __ownedHouses[_HouseBuyer].push(myHouse);

                //remove House from current ownerAddress
                delete __ownedHouses[msg.sender][i];

                //inform the world
                emit Transfer(msg.sender, _HouseBuyer, _title);

                return true;
            }
        }

        //if we still did not return, return false
        return false;
    }


}