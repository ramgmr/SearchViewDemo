package network

data class Sighting (

    /*"PMW 1808",
    {
      "created_at": "Mar 17, 2022",
      "description": "Maybe from Cedar Park?",
      "owner": "sean.swezey@gmail.com",
      "photo": "https://firebasestorage.googleapis.com/v0/b/marvin-343216.appspot.com/o/images%2Fb8ea8b40-19f7-451f-9129-632d6924b429?alt=media&token=7e888a9d-b2c0-40f2-8328-b513d78da00d",
      "tags": "#Toyota #Camry #White",
      "title": "Much closer!",
      "updated_at": "2022-03-17T04:36:04.779"
    }
*/

    val license_plate: String,
    val created_at: String,
    val updated_at: String,
    val description: String,
    val owner: String,
    val photo: String,
    val tags: String,
    val title: String
)