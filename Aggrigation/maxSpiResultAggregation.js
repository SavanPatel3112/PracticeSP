db.getCollection("user").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: {
			  _id: {
			    $in: [
			      { $oid: "6304632fac7d94508596a6ef" },
			      { $oid: "62f0eaa91dd83e487c4340de" },
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
			      cond: { $eq: ["$$item.spi", { $max: "$result.spi" }] },
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
