using System;
using Gtk;

public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}

	protected void OnSumaClicked (object sender, EventArgs e)
	{
		decimal numero1 = decimal.Parse (entrynumero1.Text);
		decimal numero2 = decimal.Parse (entrynumero2.Text);
		decimal resultado = (numero1 + numero2);

		labelresultado.Text = resultado.ToString();
	}
}