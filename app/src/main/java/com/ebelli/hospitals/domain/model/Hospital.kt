package com.ebelli.hospitals.domain.model

import com.google.gson.annotations.SerializedName

/*/
    "OrganisationID": 1421,
    "OrganisationCode": "RV9HE",
    "OrganisationType": "Hospital",
    "SubType": "Mental Health Hospital",
    "Sector": "NHS Sector",
    "OrganisationStatus": "Visible",
    "IsPimsManaged": "True",
    "OrganisationName": "East Riding Community Hospital",
    "Address1": "Swinemoor Lane",
    "Address2": "",
    "Address3": "",
    "City": "Beverley",
    "County": "East Yorkshire",
    "Postcode": "HU17 0FA",
    "Latitude": 53.85313415527344,
    "Longitude": -0.4114723205566406,
    "ParentODSCode": "RV9",
    "ParentName": "Humber NHS Foundation Trust",
    "Phone": "01482 886600",
    "Email": "newhospital@nhs.net",
    "Website": "http://www.humber.nhs.uk",
    "Fax": ""
 */
data class Hospital (
    @SerializedName("OrganisationID")
    val id: Int
)