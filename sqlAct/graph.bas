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
	' Declare global variables here
End Sub

Sub Globals
	Dim pnlChart As Panel ' Panel to display the chart
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("Layout1") ' Ensure your layout contains pnlChart
End Sub


Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
