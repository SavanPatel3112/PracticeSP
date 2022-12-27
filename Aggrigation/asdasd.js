db.getCollection("bookPurchaseLog").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$set: { month: { $month: "$date" }, year: { $year: "$date" } }
		},

		// Stage 2
		{
			$match: { year: 2021 }
		},

		// Stage 3
		{
			$match: { month: 9 }
		},

		// Stage 4
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

		// Stage 5
		{
			$unwind: { path: "$student" }
		},

		// Stage 6
		{
			$group: {
			  price: { $sum: "$price" },
			  count: { $sum: 1 },
			  fullName: { $first: "$student.fullName" },
			  _id: { userId: "$userId" },
			  bookName: { $last: "$bookName" },
			  bookId: { $last: "$bookId" },
			},
		},

		// Stage 7
		{
			$set: { userId: "$_id.userId" }
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
