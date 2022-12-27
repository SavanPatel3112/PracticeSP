db.getCollection("bookPurchaseLog").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$set: { month: { $month: "$date" }, year: { $year: "$date" } }
		},

		// Stage 2
		{
			$match: { year: 2021,month:9 }
		},

		// Stage 3
		{
			$group: {
			  month: { $first: "$month" },
			  userIds: { $push: { $toString: "$_id" } },
			  count: { $sum: 1 },
			  _id: { month: "$month", bookName: "$bookName" },
			},
		},

		// Stage 4
		{
			$group: {
			  bookData: {
			    $push: { month: "$month", userIds: "$userIds", count: "$count" },
			  },
			  _id: "$_id.bookName",
			},
		},

		// Stage 5
		{
			$unwind: { path: "$bookData" }
		},

		// Stage 6
		{
			$group: {
			  bookData: { $push: { count: "$bookData.count", bookName: "$_id" } },
			  _id: "$bookData.month",
			  totalCount: { $sum: "$bookData.count" },
			},
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
