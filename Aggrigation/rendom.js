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
			$unwind: {
			  path: "$result",
			},
		},

		// Stage 3
		{
			$group: {
			  _id: {
			
			  },
			  max: {
			    $max: "$result.spi",
			  },
			  min: {
			    $min: "$result.spi",
			  },
			},
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
