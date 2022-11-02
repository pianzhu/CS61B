public class NBody {
	public static double readRadius(String file_name) {
		In in = new In(file_name);
		int n = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String file_name) {
		In in = new In(file_name);
		int n = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[n];
		for (int i = 0; i < n; i++) {
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
	public static void main(String[] args) {
		double T = new Double(args[0]);
		double dt = new Double(args[1]);
		String filename = args[2];
		double r = NBody.readRadius(filename);
		Planet[] planets = NBody.readPlanets(filename);
		// StdDraw.setScale(-radius, radius);
		int t = 0;
		StdDraw.setXscale(-r, r);
		StdDraw.setYscale(-r, r);
		int n = planets.length;
		StdDraw.picture(0, 0, "images/starfield.jpg");
		while (t <= T) {
			StdDraw.enableDoubleBuffering();
			double[] xForces = new double[n];
			double[] yForces = new double[n];
			for (int i = 0; i < n; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i < n; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (int i = 0; i < n; i++) {
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