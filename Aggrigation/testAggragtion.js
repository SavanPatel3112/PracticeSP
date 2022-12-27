db.getCollection("bookPurchaseLog").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: {
			  softDelete: false,
			  userId: { $in: ["62eb607d9c735854c58f83dd", "62eb60ed9c735854c58f83de"] },
			},
		},

		// Stage 2
		{
			$lookup: {
			  pipeline: [
			    { $match: { $and: [{ $expr: { $eq: ["$_id", "$$userId"] } }] } },
			  ],
			  as: "student",
			  from: "users",
			  let: { userId: { $toObjectId: "$userId" } },
			},
		},

		// Stage 3
		{
			$unwind: { path: "$student" }
		},

		// Stage 4
		{
			$set: { fulName: "$student.fullName", balance: "$student.balance" }
		},

		// Stage 5
		{
			$unset: "student"
		},

		// Stage 6
		{
			$group: { _id: null, count: { $sum: 1 } }
		},

		// Stage 7
		{
			$project: { count: 1 }
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
