db.getCollection("users").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: { softDelete: false }
		},

		// Stage 2
		{
			$set: { year: { $year: "$date" }, month: { $month: "$date" } }
		},

		// Stage 3
		{
			$match: { year: 2021 }
		},

		// Stage 4
		{
			$group: {
			  _id: "$month",
			  month: { $first: "$month" },
			  year: { $first: "$year" },
			  count: { $sum: 1 },
			  userIds: { $push: { $toString: "$_id" } },
			},
		},

		// Stage 5
		{
			$sort: { month: 1 }
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
