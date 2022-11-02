public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p) {
		double x = p.xxPos - xxPos;
		double y = p.yyPos - yyPos;
		return Math.sqrt(x * x + y * y);
		// return Math.sqrt(Math.pow(p.xxPos - xxPos, 2) + Math.pow(p.yyPos - yyPos, 2));
	}
	public double calcForceExertedBy(Planet p) {
		double distance = calcDistance(p);
		double G = 6.67e-11;
		return G * p.mass * mass / (distance * distance);
	}
	public double calcForceExertedByX(Planet p) {
		double gravitation = calcForceExertedBy(p);
		return gravitation * (p.xxPos - xxPos) / calcDistance(p);
	}
	public double calcForceExertedByY(Planet p) {
		double gravitation = calcForceExertedBy(p);
		return gravitation * (p.yyPos - yyPos) / calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] p) {
		double net_force = 0;
		for (int i = 0; i < p.length; i++) {
			if (this.equals(p[i])) {
				continue;
			}
			net_force += calcForceExertedByX(p[i]);
		}
		return net_force;
	}
	public double calcNetForceExertedByY(Planet[] p) {
		double net_force = 0;
		for (int i = 0; i < p.length; i++) {
			if (this.equals(p[i])) {
				continue;
			}
			net_force += calcForceExertedByY(p[i]);
		}
		return net_force;
	}
	public void update(double dt, double fx, double fy) {
		double ax = fx / mass;
		double ay = fy / mass;
		xxVel = xxVel + ax * dt;
		yyVel = yyVel + ay * dt;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}
	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}
}