db.getCollection("user").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: {
			_id:{
			  $in:[
			  {$oid:"631044162c34e0612b3573e6"},
			  {$oid:"631043676114d41cb37e87c4"},
			  ],
			  },
			  softDelete:false,
			},
		},

		// Stage 2
		{
			$project: {
			  minResult: {
			    $filter: {
			      input: "$result",
			      as: "item",
			      cond: {$eq:["$$item.spi", { $min: "$result.spi" }]},
			    },
			  },
			  maxResult: {
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
