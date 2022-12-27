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
			  _id: {fullName:"$fulName",bookName:"$bookName"},
			  userBookDetails:{
			  $push: {
			    date:"$date",
			  	price:"$price",
			  	count:{$sum:1},
			  },
			  },
			},
		},

		// Stage 7
		{
			$match: {
			  
			
			}
		},

		// Stage 8
		{
			$set: { fullName: "$_id.fullName" }
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
