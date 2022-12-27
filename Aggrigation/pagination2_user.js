db.getCollection("user").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$addFields: {
			  search: {
			    $concat: [
			      {
			        $ifNull: ["$firstName", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$lastName", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$middleName", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$fullName", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$address.addressLine1", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$address.addressLine2", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$address.addressLine3", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$address.city", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$address.state", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$address.zipCode", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$age", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$email", ""],
			      },
			      "|@|",
			      {
			        $ifNull: ["$userName", ""],
			      },
			    ],
			  },
			},
		},

		// Stage 2
		{
			$match: {
			  softDelete: false,
			},
		},

		// Stage 3
		{
			$group: {
			  _id: null,
			  count: {
			    $sum: 1,
			  },
			},
		},

		// Stage 4
		{
			$project: {
			    // specifications
			}
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
