db.getCollection("user").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: {
			  _id: {
			    $in: [
			      {
			        $oid: "62eb607d9c735854c58f83dd",
			      },
			      {
			        $oid: "62ea7609e4eb6b6d0bf0aebc",
			      },
			    ],
			  },
			  softDelete: false,
			},
		},

		// Stage 2
		{
			$project: {
			    result: {
			        $filter: {
			            input: "$result",
			            as: "item",
			            cond: { $eq: ["$$item.spi", { $max: "$result.spi" }] }
			        }
			    }
			}
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
