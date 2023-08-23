public class Planet 
{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;

	public double mass;

	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) 
	{
		xxPos = xP; yyPos = yP;
		xxVel = xV; yyVel = yV;
		mass = m; 
		imgFileName = img;
	}

	public Planet(Planet b) {
		xxPos = b.xxPos; yyPos = b.yyPos;
		xxVel = b.xxVel; yyVel = b.yyVel;
		mass = b.mass; imgFileName = b.imgFileName;
	}

	public double calcDistance(Planet p) {
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double calcForceExertedBy(Planet p) {
		double G = 6.67 * Math.pow(10, -11);
		double F = G * mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
		return F;
	}

	public double calcForceExertedByX(Planet p) {

		double r = calcDistance(p);
		double F = calcForceExertedBy(p);

		return (p.xxPos - this.xxPos) / r * F;
	}

	public double calcForceExertedByY(Planet p) {
		
		double r = calcDistance(p);
		double F = calcForceExertedBy(p);

		return (p.yyPos - this.yyPos) / r * F;
	}


	public double calcNetForceExertedByX(Planet[] planets) {

		double FxNet = 0.0;
		for (int i = 0; i < planets.length; ++i) {
			FxNet += this.calcForceExertedByX(planets[i]);
		}
		return FxNet;
	}

	public double calcNetForceExertedByY(Planet[] planets) {
		double FyNet = 0.0;
		for (int i = 0; i < planets.length; ++i) {
			FyNet += this.calcForceExertedByY(planets[i]);
		}
		return FyNet;
	}
	public void update(double dt, double Fx, double Fy) {

		double xxAcc = Fx / mass;
		double yyAcc = Fy / mass;

		xxVel = xxVel + dt * xxAcc;
		yyVel = yyVel + dt * yyAcc;

		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;

	}

	public void draw() {
		String imageToDraw = "images/" + imgFileName;
		StdDraw.picture(xxPos, yyPos, imageToDraw);	
	}

}


