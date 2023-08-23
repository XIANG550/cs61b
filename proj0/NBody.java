public class NBody {

	public static double readRadius(String filePath) 
	{
		In in = new In(filePath);
		int N = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String filePath) 
	{
		In in = new In(filePath);
		int N = in.readInt();
		double radius = in.readDouble();

		Planet[] planets = new Planet[N];
		for (int i = 0; i < N; ++i) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return planets;

	}

	public static void main(String[] args) 
	{
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String fileName = args[2];

		Planet[] planets;
		planets = readPlanets(fileName);

		double radius = readRadius(fileName);
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();


		String imageToDraw = "images/starfield.jpg";
		StdDraw.picture(0, 0, imageToDraw);

		
		for (int i = 0; i < planets.length; ++i) {
			planets[i].draw();
		}

		StdDraw.enableDoubleBuffering();
		
		int num = planets.length;
		double t = 0.0;
		while (t < T) {

			double[] xForces = new double[num];
			double[] yForces = new double[num];

			for (int i = 0; i < num; ++i) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);

				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, imageToDraw);
			for (int i = 0; i < planets.length; ++i) {
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);

			t += dt;

		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                 planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                 planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}

	}
}