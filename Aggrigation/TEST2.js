db.getCollection("bookPurchaseLog").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: { softDelete: false }
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
			$set: { fulName: "$student.fullName" }
		},

		// Stage 5
		{
			$unset: "student"
		},

		// Stage 6
		{
			$group: {
			  bookData: {
			    $push: {
			      date: "$date",
			      price: "$price",
			      fullName: "$fulName",
			      userId: "$userId",
			    },
			  },
			  count: { $sum: 1 },
			  _id: { bookName: "$bookName" },
			},
		},

		// Stage 7
		{
			$set: {
				bookName:"$_id.bookName",
			}
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
