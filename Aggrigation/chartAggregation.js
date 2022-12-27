db.getCollection("user").aggregate(

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
			  month:{$first:"$month"},
			  year:{$first:"$year"},
			  count: { $sum: 1 },
			  userIds: { $push: { $toString: "$_id" } },
			},
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
