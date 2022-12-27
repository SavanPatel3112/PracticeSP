db.getCollection("bookPurchaseLog").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: { softDelete: false }
		},

		// Stage 2
		{
			$set: { month: { $month: "$date" }, year: { $year: "$date" } }
		},

		// Stage 3
		{
			$match: { year: 2021,month:9 }
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
			  _id: { userId:"$userId" },
			  count: { $sum: 1 },
			  price:{$sum:"$price"},
			  bookId:{"$last":"$bookId"},
			  bookName:{"$last":"$bookName"},
			  fullName:{"$first":"$student.fullName"}
			}
		},

		// Stage 7
		{
			$set: {
			 userId: "$_id.userId",
			}
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
