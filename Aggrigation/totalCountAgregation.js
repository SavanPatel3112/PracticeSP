db.getCollection("users").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: { softDelete: false }
		},

		// Stage 2
		{
			$set: {
			   year: { $year: "$date" }
			}
		},

		// Stage 3
		{
			$match: {
			  year:2022
			}
		},

		// Stage 4
		{
			$group: {
			  _id:"$year",
			  count: { $sum: 1 },
			},
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
