# Revision info #
* $HeadURL: https://cscs-repast-demos.googlecode.com/svn/richard/StupidModel/tags/2011_05_29_model_05/TODO.md $
* $LastChangedDate: 2011-05-30 09:28:48 +0200 (H, 30 máj. 2011) $
* $LastChangedRevision: 191 $
* $LastChangedBy: richard.legendi@gmail.com $
* $Id: TODO.md 191 2011-05-30 07:28:48Z richard.legendi@gmail.com $

# TODO #
This file contains some minor-major current TODO elements.

## General ##

### Possible bugs? ###
* Reinit fails for some reason sometimes: 2-3 init calls are required to display the grid, why?

## Model 4##
* How to probe ValueLayerProbeObject2D? There are 2 options here:
	* The HabitatCells may be probed. This way we have no Value Layers, but HabitatCell objects in the grid
	  The Bug's move action need a bit of update. 
	* We use value layers and see the grass growing

* Commit backwards:
	* Bug#foodConsumption() from Model 3
	* Multi occuppancy from Model 3
