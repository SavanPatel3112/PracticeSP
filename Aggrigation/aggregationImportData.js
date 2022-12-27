db.getCollection("import_data").aggregate([
  {
    $match: {
      _id: {
        $in: [
          {
            $oid: "6321b58a2da6c248c64d3512",
          },
          {
            $oid: "6321b58a2da6c248c64d3513",
          },
        ],
      },
      softDelete: false,
    },
  },
  {
    $match: {
      "userIdImport.id": [
        "6321b58a2da6c248c64d3512",
        "6321b58a2da6c248c64d3513",
      ],
    },
  },
]);
