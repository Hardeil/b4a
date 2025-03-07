B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=13.1
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private xui As XUI
	Dim strURL As String = "http://192.168.8.140/sample/api.php?action=get_data"

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Type VideoDetails (VideoURL As String)
	Dim LeaderList As List
	Dim TableDetails As List
	Private Button1 As Button
	Private Button2 As Button
	Private Label1 As Label
	Private Label2 As Label
	Private Label3 As Label
	Private Label4 As Label
	Private Label5 As Label
	Private Label6 As Label
	Dim PHPURL = "http://192.168.8.140/sample/api.php?action=get_data" As String
	Type Records (FirstName As String, LastName As String,Age As Int)
	Dim myRecords(3) As Records
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("crud")

	LoadMySQLData 
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub LoadMySQLData 
	Dim Job1 As HttpJob
	Job1.Initialize("LoadData",Me)
	Job1.Download(PHPURL)
	ProgressDialogShow("Loading Data .... ")
End Sub

Sub JobDone (job As HttpJob)
	If job.Success = True Then
		
		Dim parser As JSONParser
		
		parser.Initialize(job.GetString)
		TableDetails = parser.NextArray
		Dim myRecords(TableDetails.Size) As Records
		
		For i=0 To TableDetails.Size-1 
			Dim m As Map
			m = TableDetails.Get(i)
			myRecords(i).FirstName = m.Get("name")
			Log(myRecords(i).FirstName)
			
		Next
		'Log(TableDetails)
	'	DisplayRecords
		
		Else	
			ToastMessageShow("Error: " & job.ErrorMessage,False)
	End If
	
	job.Release
End Sub
