db.getCollection("user").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: {
			_id:{
			  $in:[
			  {$oid:"63071b82a86b151b3f17b220"},
			  {$oid:"6308b9d32240cd1be9ebd68b"},
			  ],
			  },
			  softDelete:false,
			},
		},

		// Stage 2
		{
			$project: {
			  result: {
			    $filter: {
			      input: "$result",
			      as: "item",
			      cond: {$eq:["$$item.spi", { $min: "$result.spi" }]},
			    },
			  },
			    result: {
			    $filter: {
			      input: "$result",
			      as: "item",
			      cond: {$eq:["$$item.spi", { $max: "$result.spi" }]},
			    },
			  },
			  
			    firstName: 1,
			    middleName: 1,
			    lastName: 1,
			    address: 1,
			    cgpa: 1,
			},
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
