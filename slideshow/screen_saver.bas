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
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")

End Sub


Sub ItemPanel_Touch (Action As Int, X As Float, Y As Float)
	LastActiveTime = DateTime.Now
	Log("User is Active Now (ItemPanel Touched)")
	Timer1_Tick ' Force-check idle state
End Sub

Sub PE_KeyPress (KeyCode As Int)
	LastActiveTime = DateTime.Now
	Log("User is Active Now (Key Pressed)")
End Sub

Sub ScrollView1_Touch (Action As Int, X As Float, Y As Float)
	If Action = 0 Then ' ACTION_DOWN event
		LastActiveTime = DateTime.Now
		Log("User is Active (ScrollView Touched)")
		Timer1_Tick ' Force-check idle state immediately
	End If
End Sub

' Detect screen touch
Sub Activity_Touch (Action As Int, X As Float, Y As Float)
	LastActiveTime = DateTime.Now
	Log("User is Active (Screen Touched)")
End Sub

Sub Timer1_Tick
	' Change index and update the image
	
	If (DateTime.Now - LastActiveTime) > IdleThreshold Then
		Log("Phone is Idle - Playing Video")
		CurrentIndex = (CurrentIndex + 1) Mod Images.Size
		imgSlide.Bitmap = Images.Get(CurrentIndex)
		imgSlide.Visible = True
		ScrollView1.Visible = False
	Else
		Log("Phone is Active - Stopping Video")
		imgSlide.Visible = False
		ScrollView1.Visible = True
	End If
End Sub


Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
