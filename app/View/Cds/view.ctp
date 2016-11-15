<div class="cds view">
<h2><?php echo __('Cd'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($cd['Cd']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Cadeira'); ?></dt>
		<dd>
			<?php echo h($cd['Cd']['cadeira']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Funcionario'); ?></dt>
		<dd>
			<?php echo $this->Html->link($cd['Funcionario']['id'], array('controller' => 'funcionarios', 'action' => 'view', $cd['Funcionario']['id'])); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Cd'), array('action' => 'edit', $cd['Cd']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Cd'), array('action' => 'delete', $cd['Cd']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $cd['Cd']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Cds'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Cd'), array('action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Funcionarios'), array('controller' => 'funcionarios', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Funcionario'), array('controller' => 'funcionarios', 'action' => 'add')); ?> </li>
	</ul>
</div>
